.class public Lorg/drinkless/tdlib/TdApi$OpenSponsoredChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OpenSponsoredChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x339de425


# instance fields
.field public sponsoredChatUniqueId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17052
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 17053
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 17043
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 17044
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$OpenSponsoredChat;->sponsoredChatUniqueId:J

    .line 17045
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17049
    const v0, 0x339de425

    return v0
.end method
