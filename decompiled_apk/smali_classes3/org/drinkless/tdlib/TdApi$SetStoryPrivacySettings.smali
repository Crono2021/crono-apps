.class public Lorg/drinkless/tdlib/TdApi$SetStoryPrivacySettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetStoryPrivacySettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2716bcce


# instance fields
.field public privacySettings:Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;

.field public storyId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32008
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32009
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$StoryPrivacySettings;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "storyPrivacySettings"    # Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;

    .line 31998
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31999
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SetStoryPrivacySettings;->storyId:I

    .line 32000
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetStoryPrivacySettings;->privacySettings:Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;

    .line 32001
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32005
    const v0, -0x2716bcce

    return v0
.end method
