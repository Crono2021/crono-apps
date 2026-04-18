.class public Lorg/drinkless/tdlib/TdApi$UpdateChatRevenueAmount;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatRevenueAmount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3936433c


# instance fields
.field public chatId:J

.field public revenueAmount:Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34328
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34329
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatRevenueAmount;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatRevenueAmount"    # Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;

    .line 34318
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34319
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatRevenueAmount;->chatId:J

    .line 34320
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatRevenueAmount;->revenueAmount:Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;

    .line 34321
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34325
    const v0, -0x3936433c

    return v0
.end method
