.class public Lorg/drinkless/tdlib/TdApi$MessageSenderUser;
.super Lorg/drinkless/tdlib/TdApi$MessageSender;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSenderUser"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x14089f1d


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16746
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSender;-><init>()V

    .line 16747
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 16737
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSender;-><init>()V

    .line 16738
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSenderUser;->userId:J

    .line 16739
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16743
    const v0, -0x14089f1d

    return v0
.end method
