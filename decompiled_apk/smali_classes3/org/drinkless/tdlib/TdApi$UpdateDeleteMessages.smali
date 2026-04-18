.class public Lorg/drinkless/tdlib/TdApi$UpdateDeleteMessages;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateDeleteMessages"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x637ec64e


# instance fields
.field public chatId:J

.field public fromCache:Z

.field public isPermanent:Z

.field public messageIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46014
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46015
    return-void
.end method

.method public constructor <init>(J[JZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "jArr"    # [J
    .param p4, "z8"    # Z
    .param p5, "z9"    # Z

    .line 46002
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46003
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateDeleteMessages;->chatId:J

    .line 46004
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateDeleteMessages;->messageIds:[J

    .line 46005
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateDeleteMessages;->isPermanent:Z

    .line 46006
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateDeleteMessages;->fromCache:Z

    .line 46007
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46011
    const v0, 0x637ec64e

    return v0
.end method
