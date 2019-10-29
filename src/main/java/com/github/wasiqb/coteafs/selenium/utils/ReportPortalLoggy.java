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
     * @author Wasiq Bhamla
     * @since 26-Oct-2019
     * @param level
     * @param file
     * @param message
     * @param args
     */
    public static void log (final LogLevel level, final File file, final String message, final Object... args) {
        emitLog (format (message, args), level.name ()
            .toLowerCase (), new Date (), file);
    }

    /**
     * @author Wasiq Bhamla
     * @since 26-Oct-2019
     * @param level
     * @param message
     * @param args
     */
    public static void log (final LogLevel level, final String message, final Object... args) {
        emitLog (format (message, args), level.name ()
            .toLowerCase (), new Date ());
    }

    private ReportPortalLoggy () {
        // Utility class.
    }
}