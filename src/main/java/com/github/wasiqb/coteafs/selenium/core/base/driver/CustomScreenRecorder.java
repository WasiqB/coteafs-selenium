/*
 * Copyright (c) 2019, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wasiqb.coteafs.selenium.core.base.driver;

import static java.text.MessageFormat.format;
import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.Registry.getInstance;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.wasiqb.coteafs.logger.Loggy;
import com.github.wasiqb.coteafs.selenium.config.ConfigUtil;
import com.github.wasiqb.coteafs.selenium.config.RecorderSetting;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

/**
 * @author Wasiq Bhamla
 * @since 27-Oct-2019
 */
class CustomScreenRecorder extends ScreenRecorder {
    private static final Loggy           LOG              = Loggy.init ();
    private static final RecorderSetting RECORDER_SETTING = ConfigUtil.appSetting ()
        .getPlayback ()
        .getRecording ();
    private static ScreenRecorder        screenRecorder;

    static void startRecording () throws Exception {
        if (checkIfEnabled ()) {
            LOG.i ("Started Video screen recording...");
            final File file = new File (RECORDER_SETTING.getPath ());

            final Dimension screenSize = Toolkit.getDefaultToolkit ()
                .getScreenSize ();
            final int width = screenSize.width;
            final int height = screenSize.height;

            final Rectangle captureSize = new Rectangle (0, 0, width, height);

            final GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment ()
                .getDefaultScreenDevice ()
                .getDefaultConfiguration ();

            screenRecorder = new CustomScreenRecorder (gc, captureSize,
                new Format (MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format (MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                    Rational.valueOf (15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format (MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf (30)),
                null, file);

            screenRecorder.start ();
        } else {
            LOG.w ("Video screen recording is Disabled, cannot start...");
        }
    }

    static void stopRecording () throws Exception {
        if (checkIfEnabled ()) {
            LOG.i ("Stopping Video screen recording...");
            screenRecorder.stop ();
        } else {
            LOG.w ("Video screen recording is Disabled, cannot stop...");
        }
    }

    private static boolean checkIfEnabled () {
        return RECORDER_SETTING != null && RECORDER_SETTING.isEnable ();
    }

    private final String prefix;

    private CustomScreenRecorder (final GraphicsConfiguration cfg, final Rectangle captureArea, final Format fileFormat,
        final Format screenFormat, final Format mouseFormat, final Format audioFormat, final File movieFolder)
        throws IOException, AWTException {
        super (cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.prefix = RECORDER_SETTING.getPrefix ();
    }

    @Override
    protected File createMovieFile (final Format fileFormat) throws IOException {
        if (!this.movieFolder.exists ()) {
            this.movieFolder.mkdirs ();
        } else if (!this.movieFolder.isDirectory ()) {
            throw new IOException (format ("\"{0}\" is not a directory.", this.movieFolder));
        }
        final SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd-HHmmss");
        return new File (this.movieFolder, format ("{0}-{1}.{2}", this.prefix, dateFormat.format (new Date ()),
            getInstance ().getExtension (fileFormat)));
    }
}