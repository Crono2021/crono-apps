.class public Lorg/drinkless/tdlib/TdApi$ResendMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ResendMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Messages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1f5fd716


# instance fields
.field public chatId:J

.field public messageIds:[J

.field public paidMessageStarCount:J

.field public quote:Lorg/drinkless/tdlib/TdApi$InputTextQuote;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44958
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44959
    return-void
.end method

.method public constructor <init>(J[JLorg/drinkless/tdlib/TdApi$InputTextQuote;J)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "jArr"    # [J
    .param p4, "inputTextQuote"    # Lorg/drinkless/tdlib/TdApi$InputTextQuote;
    .param p5, "j9"    # J

    .line 44946
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44947
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ResendMessages;->chatId:J

    .line 44948
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ResendMessages;->messageIds:[J

    .line 44949
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ResendMessages;->quote:Lorg/drinkless/tdlib/TdApi$InputTextQuote;

    .line 44950
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$ResendMessages;->paidMessageStarCount:J

    .line 44951
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44955
    const v0, 0x1f5fd716    # 4.7400002E-20f

    return v0
.end method
