package com.example.wan_android.bean;

import java.util.List;

/**
 * Created by apcnl on 2019/5/24.
 */

public class SearchChildBean {


    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":"coder_yu","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8163,"link":"https://www.jianshu.com/p/3afa47e9112e","niceDate":"2019-03-27","origin":"","prefix":"","projectLink":"","publishTime":1553698757000,"superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"Android类加载机制的细枝<em class='highlight'>末<\/em>节","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7636,"link":"https://mp.weixin.qq.com/s/FD4s0RMRqAy5b_NsrK3Oog","niceDate":"2018-12-10","origin":"","prefix":"","projectLink":"","publishTime":1544371200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"Flutter学习指南：封装 API 插件 | 文<em class='highlight'>末<\/em>附中奖名单","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5040,"link":"http://mp.weixin.qq.com/s?__biz=MzIwMTAzMTMxMg==&mid=2649493231&idx=2&sn=bbe2a9a662f6ad66270cee70646b23d9&chksm=8eec8510b99b0c066cb5738aa571b47547fb6abee0b9e0978b4c0faddf802f332e14423c01d1&scene=38#wechat_redirect","niceDate":"2018-09-30","origin":"","prefix":"","projectLink":"","publishTime":1538236800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"【文<em class='highlight'>末<\/em>福利】安卓巴士全球开发者论坛北京站即将开启！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5393,"link":"http://mp.weixin.qq.com/s?__biz=MzIxNzU1Nzk3OQ==&mid=2247487043&idx=1&sn=c547106fbe65b500dd1ab3e78cefeac1&chksm=97f6b0f7a08139e159abc3f42a8a8e370a6b5b174cbb1c94bec5daafda4741088749bbf76b3f&scene=38#wechat_redirect","niceDate":"2018-06-15","origin":"","prefix":"","projectLink":"","publishTime":1528992000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"这是我的终点，也是新的起点！（文<em class='highlight'>末<\/em>赠书）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":249,"chapterName":"干货资源","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2332,"link":"https://mp.weixin.qq.com/s/6q4fg84rvHi18v-34ScRrA","niceDate":"2018-02-10","origin":"","prefix":"","projectLink":"","publishTime":1518230246000,"superChapterId":249,"superChapterName":"干货资源","tags":[],"title":"年<em class='highlight'>末<\/em>文章总结 大家新年快乐","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":4090,"link":"http://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650825020&idx=1&sn=a27fda5313ae02c23e416f238bc21620&chksm=80b7b5a2b7c03cb423f7a95852c28acc853f49772789abc53c031579def74c728245005bc6b6&scene=38#wechat_redirect","niceDate":"2018-02-10","origin":"","prefix":"","projectLink":"","publishTime":1518192000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"年<em class='highlight'>末<\/em>文章总结 大家新年快乐","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"承香墨影","chapterId":411,"chapterName":"承香墨影","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":4912,"link":"http://mp.weixin.qq.com/s?__biz=MzIxNjc0ODExMA==&mid=2247485042&idx=1&sn=bc79dc1a589ee029b47e6061907a8471&chksm=97851f53a0f296453866687b9056476898cdeac54861ebaf66d754ef04027e747a4a9f43c956&scene=38#wechat_redirect","niceDate":"2017-12-18","origin":"","prefix":"","projectLink":"","publishTime":1513526400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/411/1"}],"title":"【深度好文】你程序员的职业生涯，都规划好了吗？ | 文<em class='highlight'>末<\/em>福利","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3645,"link":"http://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650824672&idx=1&sn=d95b8753250ee87cc9ea2a2230ecf2f9&chksm=80b78b7eb7c002682ad8b3191983f42ddf98244cf85a1807fb4b8448310fb190ef86b38263d1&scene=38#wechat_redirect","niceDate":"2017-12-14","origin":"","prefix":"","projectLink":"","publishTime":1513180800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"文<em class='highlight'>末<\/em>赠书 | WebView截长图解决方案","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"美团技术团队","chapterId":417,"chapterName":"美团技术团队","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7071,"link":"http://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651747208&idx=5&sn=7dabb355bc617c16c2cf8327ac206bc7&chksm=bd12aac58a6523d3556e59e7889aa40cb0578c7f2a764f13020404895da8c52173d4a653126d&scene=38#wechat_redirect","niceDate":"2017-12-14","origin":"","prefix":"","projectLink":"","publishTime":1513180800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/417/1"}],"title":"美团平台与酒旅事业群大型招聘，年<em class='highlight'>末<\/em>福利不要错过！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"芥末末的沫","chapterId":55,"chapterName":"新的API","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":1501,"link":"http://www.jianshu.com/p/9fb882cae239","niceDate":"2017-11-13","origin":"","prefix":"","projectLink":"","publishTime":1510571570000,"superChapterId":54,"superChapterName":"5.+高新技术","tags":[],"title":"Android Jobscheduler使用","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3698,"link":"http://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650823836&idx=1&sn=621cd0380a40991ed855433b262ae314&chksm=80b78802b7c00114331159de3e30f35d61cd8fd09b9f6234e0c58318731ea2df6a855815c5f1&scene=38#wechat_redirect","niceDate":"2017-08-21","origin":"","prefix":"","projectLink":"","publishTime":1503244800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"文<em class='highlight'>末<\/em>送书 | 自定义View之添加银行卡动画 丝滑的页面切换","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":6405,"link":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652040352&idx=1&sn=3297765cc1da591040e2ef168b53a7c2&chksm=808d4ce5b7fac5f3b9f4c6d115b15aafaa3ed0b7ce315b80739d937bcc7c8d234d974f998b1f&scene=38#wechat_redirect","niceDate":"2016-12-06","origin":"","prefix":"","projectLink":"","publishTime":1480953600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"可能是2016年<em class='highlight'>末<\/em>最值得期待的 Google 大事件","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":11}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","author":"coder_yu","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8163,"link":"https://www.jianshu.com/p/3afa47e9112e","niceDate":"2019-03-27","origin":"","prefix":"","projectLink":"","publishTime":1553698757000,"superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"Android类加载机制的细枝<em class='highlight'>末<\/em>节","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7636,"link":"https://mp.weixin.qq.com/s/FD4s0RMRqAy5b_NsrK3Oog","niceDate":"2018-12-10","origin":"","prefix":"","projectLink":"","publishTime":1544371200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"Flutter学习指南：封装 API 插件 | 文<em class='highlight'>末<\/em>附中奖名单","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5040,"link":"http://mp.weixin.qq.com/s?__biz=MzIwMTAzMTMxMg==&mid=2649493231&idx=2&sn=bbe2a9a662f6ad66270cee70646b23d9&chksm=8eec8510b99b0c066cb5738aa571b47547fb6abee0b9e0978b4c0faddf802f332e14423c01d1&scene=38#wechat_redirect","niceDate":"2018-09-30","origin":"","prefix":"","projectLink":"","publishTime":1538236800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"【文<em class='highlight'>末<\/em>福利】安卓巴士全球开发者论坛北京站即将开启！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5393,"link":"http://mp.weixin.qq.com/s?__biz=MzIxNzU1Nzk3OQ==&mid=2247487043&idx=1&sn=c547106fbe65b500dd1ab3e78cefeac1&chksm=97f6b0f7a08139e159abc3f42a8a8e370a6b5b174cbb1c94bec5daafda4741088749bbf76b3f&scene=38#wechat_redirect","niceDate":"2018-06-15","origin":"","prefix":"","projectLink":"","publishTime":1528992000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"这是我的终点，也是新的起点！（文<em class='highlight'>末<\/em>赠书）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":249,"chapterName":"干货资源","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2332,"link":"https://mp.weixin.qq.com/s/6q4fg84rvHi18v-34ScRrA","niceDate":"2018-02-10","origin":"","prefix":"","projectLink":"","publishTime":1518230246000,"superChapterId":249,"superChapterName":"干货资源","tags":[],"title":"年<em class='highlight'>末<\/em>文章总结 大家新年快乐","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":4090,"link":"http://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650825020&idx=1&sn=a27fda5313ae02c23e416f238bc21620&chksm=80b7b5a2b7c03cb423f7a95852c28acc853f49772789abc53c031579def74c728245005bc6b6&scene=38#wechat_redirect","niceDate":"2018-02-10","origin":"","prefix":"","projectLink":"","publishTime":1518192000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"年<em class='highlight'>末<\/em>文章总结 大家新年快乐","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"承香墨影","chapterId":411,"chapterName":"承香墨影","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":4912,"link":"http://mp.weixin.qq.com/s?__biz=MzIxNjc0ODExMA==&mid=2247485042&idx=1&sn=bc79dc1a589ee029b47e6061907a8471&chksm=97851f53a0f296453866687b9056476898cdeac54861ebaf66d754ef04027e747a4a9f43c956&scene=38#wechat_redirect","niceDate":"2017-12-18","origin":"","prefix":"","projectLink":"","publishTime":1513526400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/411/1"}],"title":"【深度好文】你程序员的职业生涯，都规划好了吗？ | 文<em class='highlight'>末<\/em>福利","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3645,"link":"http://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650824672&idx=1&sn=d95b8753250ee87cc9ea2a2230ecf2f9&chksm=80b78b7eb7c002682ad8b3191983f42ddf98244cf85a1807fb4b8448310fb190ef86b38263d1&scene=38#wechat_redirect","niceDate":"2017-12-14","origin":"","prefix":"","projectLink":"","publishTime":1513180800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"文<em class='highlight'>末<\/em>赠书 | WebView截长图解决方案","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"美团技术团队","chapterId":417,"chapterName":"美团技术团队","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7071,"link":"http://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651747208&idx=5&sn=7dabb355bc617c16c2cf8327ac206bc7&chksm=bd12aac58a6523d3556e59e7889aa40cb0578c7f2a764f13020404895da8c52173d4a653126d&scene=38#wechat_redirect","niceDate":"2017-12-14","origin":"","prefix":"","projectLink":"","publishTime":1513180800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/417/1"}],"title":"美团平台与酒旅事业群大型招聘，年<em class='highlight'>末<\/em>福利不要错过！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"芥末末的沫","chapterId":55,"chapterName":"新的API","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":1501,"link":"http://www.jianshu.com/p/9fb882cae239","niceDate":"2017-11-13","origin":"","prefix":"","projectLink":"","publishTime":1510571570000,"superChapterId":54,"superChapterName":"5.+高新技术","tags":[],"title":"Android Jobscheduler使用","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3698,"link":"http://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650823836&idx=1&sn=621cd0380a40991ed855433b262ae314&chksm=80b78802b7c00114331159de3e30f35d61cd8fd09b9f6234e0c58318731ea2df6a855815c5f1&scene=38#wechat_redirect","niceDate":"2017-08-21","origin":"","prefix":"","projectLink":"","publishTime":1503244800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"文<em class='highlight'>末<\/em>送书 | 自定义View之添加银行卡动画 丝滑的页面切换","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":6405,"link":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652040352&idx=1&sn=3297765cc1da591040e2ef168b53a7c2&chksm=808d4ce5b7fac5f3b9f4c6d115b15aafaa3ed0b7ce315b80739d937bcc7c8d234d974f998b1f&scene=38#wechat_redirect","niceDate":"2016-12-06","origin":"","prefix":"","projectLink":"","publishTime":1480953600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"可能是2016年<em class='highlight'>末<\/em>最值得期待的 Google 大事件","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 11
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * author : coder_yu
             * chapterId : 198
             * chapterName : 基础概念
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : false
             * id : 8163
             * link : https://www.jianshu.com/p/3afa47e9112e
             * niceDate : 2019-03-27
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1553698757000
             * superChapterId : 168
             * superChapterName : 基础知识
             * tags : []
             * title : Android类加载机制的细枝<em class='highlight'>末</em>节
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<?> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }
    }
}
