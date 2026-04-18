.class public Lorg/drinkless/tdlib/TdApi$OpenMessageContent;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OpenMessageContent"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2c0d9685


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28924
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28925
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 28914
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28915
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$OpenMessageContent;->chatId:J

    .line 28916
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$OpenMessageContent;->messageId:J

    .line 28917
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28921
    const v0, -0x2c0d9685

    return v0
.end method
