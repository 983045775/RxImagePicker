package com.qingmei2.rximagepicker.core;


import android.net.Uri;

import com.qingmei2.rximagepicker.config.RxImagePickerConfigProvider;
import com.qingmei2.rximagepicker.funtions.FuntionObserverAsConverter;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by qingmei2 on 2018/1/13.
 */
public final class RxImagePickerProcessor implements IRxImagePickerProcessor {

    private final RxImagePicker rxImagePicker;

    @Inject
    public RxImagePickerProcessor(RxImagePicker rxImagePicker) {
        this.rxImagePicker = rxImagePicker;
    }

    @Override
    public Observable<?> process(RxImagePickerConfigProvider configProvider) {
        return Observable.just(configProvider)
                .flatMap(new Function<RxImagePickerConfigProvider, ObservableSource<Uri>>() {
                    @Override
                    public ObservableSource<Uri> apply(RxImagePickerConfigProvider provider) throws Exception {
                        return rxImagePicker.requestImage(provider.getSourcesFrom());
                    }
                })
                .flatMap(new FuntionObserverAsConverter(configProvider.getObserverAs(), rxImagePicker.getActivity()));
    }

}
