package com.github.wasiqb.coteafs.selenium.utils;

import static com.epam.reportportal.service.ReportPortal.emitLog;
import static java.text.MessageFormat.format;

import java.io.File;
import java.util.Date;

/**
 * @author Wasiq Bhamla
 * @since 29-Oct-2019
 */
public final class ReportPortalLoggy {
    /**
     * @param level
     * @param file
     * @param message
     * @param args
     *
     * @author Wasiq Bhamla
     * @since 26-Oct-2019
     */
    public static void log (final LogLevel level, final File file, final String message, final Object... args) {
        emitLog (format (message, args), level.name ()
            .toLowerCase (), new Date (), file);
    }

    /**
     * @param level
     * @param message
     * @param args
     *
     * @author Wasiq Bhamla
     * @since 26-Oct-2019
     */
    public static void log (final LogLevel level, final String message, final Object... args) {
        emitLog (format (message, args), level.name ()
            .toLowerCase (), new Date ());
    }

    private ReportPortalLoggy () {
        // Utility class.
    }
}