/*
 * Copyright 2017 Zhihu Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qingmei2.rximagepicker_extension.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.qingmei2.rximagepicker_extension.entity.Album;

public class WeChatListFragment extends Fragment {

    public static final String EXTRA_ALBUM = "extra_album";

    public static WeChatListFragment instance(Album album) {
        WeChatListFragment fragment = new WeChatListFragment();
        Bundle args = new Bundle();
        args.putParcelable(EXTRA_ALBUM, album);
        fragment.setArguments(args);
        return fragment;
    }

}