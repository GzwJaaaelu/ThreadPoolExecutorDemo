package com.jaaaelu.gzw.threadpoolexecutordemo.model;

import java.util.List;

/**
 * Created by admin on 2017/1/8.
 */

public class Girls {

    /**
     * error : false
     * results : [{"_id":"586e1aad421aa9315ea79905","createdAt":"2017-01-05T18:06:37.810Z","desc":"1-5","publishedAt":"2017-01-06T13:20:19.591Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034gw1fbfwwsjh3zj20u00u00w1.jpg","used":true,"who":"daimajia"},{"_id":"586d8f74421aa9316407fb56","createdAt":"2017-01-05T08:12:36.360Z","desc":"1-5","publishedAt":"2017-01-05T13:18:10.185Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1fbffqo6jjoj20u011hgpx.jpg","used":true,"who":"daimajia "},{"_id":"586c63a6421aa94dc1ac0b02","createdAt":"2017-01-04T10:53:26.957Z","desc":"1-4","publishedAt":"2017-01-04T11:39:01.326Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1fbeerrs7aqj20u011htec.jpg","used":true,"who":"daimajia"},{"_id":"586b0915421aa94dbbd82bcf","createdAt":"2017-01-03T10:14:45.467Z","desc":"1-3","publishedAt":"2017-01-03T11:51:31.742Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1fbd818kkwjj20u011hjup.jpg","used":true,"who":"daimajia"},{"_id":"5865ad4e421aa94dbe2ccdb0","createdAt":"2016-12-30T08:41:50.830Z","desc":"12-30","publishedAt":"2016-12-30T16:16:11.125Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1fb8iv9u08ij20u00u0tc7.jpg","used":true,"who":"daimajia"},{"_id":"58645be0421aa94dbbd82bac","createdAt":"2016-12-29T08:42:08.389Z","desc":"12-29","publishedAt":"2016-12-29T11:56:56.946Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034gw1fb7d9am05gj20u011hq64.jpg","used":true,"who":"daimajia"},{"_id":"58632374421aa9723d29b9ba","createdAt":"2016-12-28T10:29:08.507Z","desc":"12-28","publishedAt":"2016-12-28T11:57:39.616Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034gw1fb6aqccs3nj20u00u0wk4.jpg","used":true,"who":"daimajia"},{"_id":"5861d315421aa97240ef9f43","createdAt":"2016-12-27T10:33:57.376Z","desc":"12-27","publishedAt":"2016-12-27T12:06:15.638Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034gw1fb558z2peqj20u00u00v9.jpg","used":true,"who":"daimajia "},{"_id":"58606820421aa9723d29b9a1","createdAt":"2016-12-26T08:45:20.537Z","desc":"12-26","publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1fb3whph0ilj20u00na405.jpg","used":true,"who":"daimajia"},{"_id":"585c9b32421aa9723a5a77b6","createdAt":"2016-12-23T11:34:10.86Z","desc":"12-23","publishedAt":"2016-12-23T11:41:19.908Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034gw1fb0kieivhgj20u00k2gmr.jpg","used":true,"who":"daimajia"}]
     */

    private boolean error;
    private List<Results> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Results {
        /**
         * _id : 586e1aad421aa9315ea79905
         * createdAt : 2017-01-05T18:06:37.810Z
         * desc : 1-5
         * publishedAt : 2017-01-06T13:20:19.591Z
         * source : chrome
         * type : 福利
         * url : http://ww4.sinaimg.cn/large/610dc034gw1fbfwwsjh3zj20u00u00w1.jpg
         * used : true
         * who : daimajia
         */

        private String publishedAt;
        private String url;

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
