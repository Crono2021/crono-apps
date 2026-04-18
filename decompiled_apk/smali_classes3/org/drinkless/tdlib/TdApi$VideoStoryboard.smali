.class public Lorg/drinkless/tdlib/TdApi$VideoStoryboard;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VideoStoryboard"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6731d8e2


# instance fields
.field public height:I

.field public mapFile:Lorg/drinkless/tdlib/TdApi$File;

.field public storyboardFile:Lorg/drinkless/tdlib/TdApi$File;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46398
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46399
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$File;IILorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "file"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "file2"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 46386
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46387
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$VideoStoryboard;->storyboardFile:Lorg/drinkless/tdlib/TdApi$File;

    .line 46388
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$VideoStoryboard;->width:I

    .line 46389
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$VideoStoryboard;->height:I

    .line 46390
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$VideoStoryboard;->mapFile:Lorg/drinkless/tdlib/TdApi$File;

    .line 46391
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46395
    const v0, 0x6731d8e2

    return v0
.end method
