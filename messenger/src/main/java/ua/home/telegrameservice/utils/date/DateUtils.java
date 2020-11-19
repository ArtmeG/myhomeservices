package ua.home.telegrameservice.utils.date;

import ua.home.telegrameservice.config.consts.covid.CovidConst;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author azatvornitskiy
 * @since 2020-11-19
 */
public class DateUtils
{
    public static String getFormattedDate(final String dateFormat, final Date date)
    {
        return new SimpleDateFormat(dateFormat).format(date);
    }

    public static String getFormattedDate(final Date date)
    {
        return getFormattedDate(CovidConst.DATE_PATTERN, date);
    }
}
