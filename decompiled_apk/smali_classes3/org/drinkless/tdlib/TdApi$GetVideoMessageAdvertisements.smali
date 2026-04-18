.class public Lorg/drinkless/tdlib/TdApi$GetVideoMessageAdvertisements;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetVideoMessageAdvertisements"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisements;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x110726b3


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26844
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26845
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 26834
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26835
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetVideoMessageAdvertisements;->chatId:J

    .line 26836
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetVideoMessageAdvertisements;->messageId:J

    .line 26837
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26841
    const v0, -0x110726b3

    return v0
.end method
