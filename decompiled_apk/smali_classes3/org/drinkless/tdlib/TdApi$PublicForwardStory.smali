.class public Lorg/drinkless/tdlib/TdApi$PublicForwardStory;
.super Lorg/drinkless/tdlib/TdApi$PublicForward;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PublicForwardStory"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7fdf26af


# instance fields
.field public story:Lorg/drinkless/tdlib/TdApi$Story;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18006
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PublicForward;-><init>()V

    .line 18007
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Story;)V
    .locals 0
    .param p1, "story"    # Lorg/drinkless/tdlib/TdApi$Story;

    .line 17997
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PublicForward;-><init>()V

    .line 17998
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PublicForwardStory;->story:Lorg/drinkless/tdlib/TdApi$Story;

    .line 17999
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18003
    const v0, 0x7fdf26af

    return v0
.end method
