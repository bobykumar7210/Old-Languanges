package dev.techasyluminfo.old_languanges;

public class Words {
    private  String mEnglish;
    private  String mMiwok;
    private int  mImageResource=NO_RESOURCE_IMAGE;

    public int getmAudioResource() {
        return mAudioResource;
    }

    public void setmAudioResource(int mAudioResource) {
        this.mAudioResource = mAudioResource;
    }

    private  int mAudioResource;
    private static final int NO_RESOURCE_IMAGE=-1;

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }




    public Words(String mEnglish, String mMiwok, int mImageResource, int mAudioResource) {
        this.mEnglish = mEnglish;
        this.mMiwok = mMiwok;
        this.mImageResource = mImageResource;
        this.mAudioResource = mAudioResource;
    }

    public Words(String mEnglish, String mMiwok, int mAudioResource) {
        this.mEnglish = mEnglish;
        this.mMiwok = mMiwok;
        this.mAudioResource = mAudioResource;

    }

    public String getmEnglish() {
        return mEnglish;
    }

    public void setmEnglish(String mEnglish) {
        this.mEnglish = mEnglish;
    }

    public String getmMiwok() {
        return mMiwok;
    }

    public void setmMiwok(String mMiwok) {
        this.mMiwok = mMiwok;
    }

    public Boolean hasImage(){
        return mImageResource==NO_RESOURCE_IMAGE;
    }

    @Override
    public String toString() {
        return "Words{" +
                "mEnglish='" + mEnglish + '\'' +
                ", mMiwok='" + mMiwok + '\'' +
                ", mImageResource=" + mImageResource +
                ", mAudioResource=" + mAudioResource +
                '}';
    }
}
