.class public Lorg/drinkless/tdlib/TdApi$GetChatBoosts;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatBoosts"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundChatBoosts;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x54a155c8


# instance fields
.field public chatId:J

.field public limit:I

.field public offset:Ljava/lang/String;

.field public onlyGiftCodes:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43326
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43327
    return-void
.end method

.method public constructor <init>(JZLjava/lang/String;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "i9"    # I

    .line 43314
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43315
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatBoosts;->chatId:J

    .line 43316
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatBoosts;->onlyGiftCodes:Z

    .line 43317
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$GetChatBoosts;->offset:Ljava/lang/String;

    .line 43318
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetChatBoosts;->limit:I

    .line 43319
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43323
    const v0, -0x54a155c8

    return v0
.end method
