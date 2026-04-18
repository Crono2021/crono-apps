.class public Lorg/drinkless/tdlib/TdApi$GetGiveawayInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetGiveawayInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GiveawayInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x48786f45


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26164
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26165
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 26154
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26155
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetGiveawayInfo;->chatId:J

    .line 26156
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetGiveawayInfo;->messageId:J

    .line 26157
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26161
    const v0, -0x48786f45

    return v0
.end method
