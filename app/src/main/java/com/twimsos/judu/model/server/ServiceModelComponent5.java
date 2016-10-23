package com.twimsos.judu.model.server;

import com.twimsos.judu.presenter.NewsTabPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 */
@Singleton
@Component(modules = {ServiceAPIModule5.class})
public interface ServiceModelComponent5 {

    void injectNewsPresenter(NewsTabPresenter model);
}