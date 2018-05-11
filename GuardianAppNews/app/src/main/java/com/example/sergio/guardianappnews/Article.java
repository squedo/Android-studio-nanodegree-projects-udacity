package com.example.sergio.guardianappnews;

public class Article {

    //Title of the article
    private String mWebTitle;

    //Publication date of the article
    private String mWebPublicationDate;

    //url to read the article
    private String mWebUrl;

    public Article(String webTitle, String webPublicationDate, String webUrl) {
        mWebTitle = webTitle;
        mWebPublicationDate = webPublicationDate;
        mWebUrl = webUrl;
    }

    //Get the title of the article
    public String getWebTitle (){
        return mWebTitle;
    }

    //Get the publication date of the article
    public String getWebPublicationDate(){ return mWebPublicationDate; }

    //Get url of the article to read it
    public String getWebUrl(){ return mWebUrl; }

}
