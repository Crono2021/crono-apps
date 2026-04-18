.class public Lorg/drinkless/tdlib/TdApi$StoryAlbum;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryAlbum"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x14a27005


# instance fields
.field public id:I

.field public name:Ljava/lang/String;

.field public photoIcon:Lorg/drinkless/tdlib/TdApi$Photo;

.field public videoIcon:Lorg/drinkless/tdlib/TdApi$Video;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45654
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45655
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;Lorg/drinkless/tdlib/TdApi$Video;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p4, "video"    # Lorg/drinkless/tdlib/TdApi$Video;

    .line 45642
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45643
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$StoryAlbum;->id:I

    .line 45644
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StoryAlbum;->name:Ljava/lang/String;

    .line 45645
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StoryAlbum;->photoIcon:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 45646
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$StoryAlbum;->videoIcon:Lorg/drinkless/tdlib/TdApi$Video;

    .line 45647
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45651
    const v0, -0x14a27005

    return v0
.end method
