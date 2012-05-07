package com.github.nmorel.sickbeard.client.request;

import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;

/**
 * A request used to call SickBeard
 *
 * @author Nicolas Morel
 * @param <T> Type of the result
 */
public interface Request<T>
{
    /**
     * Call SickBeard
     *
     * @return the call's result
     * @throws SickBeardException
     */
    T call()
        throws SickBeardException;
}
