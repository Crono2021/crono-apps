.class public Lorg/drinkless/tdlib/TdApi$ReportSponsoredChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportSponsoredChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ReportSponsoredResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x35cdb27b


# instance fields
.field public optionId:[B

.field public sponsoredChatUniqueId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30228
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30229
    return-void
.end method

.method public constructor <init>(J[B)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "bArr"    # [B

    .line 30218
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30219
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReportSponsoredChat;->sponsoredChatUniqueId:J

    .line 30220
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ReportSponsoredChat;->optionId:[B

    .line 30221
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30225
    const v0, -0x35cdb27b

    return v0
.end method
