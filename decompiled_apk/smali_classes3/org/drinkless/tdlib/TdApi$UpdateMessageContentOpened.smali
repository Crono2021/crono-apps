.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageContentOpened;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageContentOpened"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5aa1577b


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34608
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34609
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 34598
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34599
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageContentOpened;->chatId:J

    .line 34600
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageContentOpened;->messageId:J

    .line 34601
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34605
    const v0, -0x5aa1577b

    return v0
.end method
