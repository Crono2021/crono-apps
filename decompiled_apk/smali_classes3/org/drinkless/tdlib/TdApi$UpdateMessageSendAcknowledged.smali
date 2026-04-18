.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageSendAcknowledged;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageSendAcknowledged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4da7d239


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34648
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34649
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 34638
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34639
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageSendAcknowledged;->chatId:J

    .line 34640
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageSendAcknowledged;->messageId:J

    .line 34641
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34645
    const v0, 0x4da7d239    # 3.5194653E8f

    return v0
.end method
