.class public Lorg/drinkless/tdlib/TdApi$PushReceiverId;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushReceiverId"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x161ddf2c


# instance fields
.field public id:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18240
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 18241
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 18231
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 18232
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PushReceiverId;->id:J

    .line 18233
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18237
    const v0, 0x161ddf2c

    return v0
.end method
