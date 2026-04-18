.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeSupergroupBoost;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeSupergroupBoost"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6fa8fb8a


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16008
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 16009
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhoto;)V
    .locals 0
    .param p1, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 15999
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 16000
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeSupergroupBoost;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 16001
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16005
    const v0, -0x6fa8fb8a

    return v0
.end method
