.class public Lorg/drinkless/tdlib/TdApi$CallStatePending;
.super Lorg/drinkless/tdlib/TdApi$CallState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallStatePending"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3ff56c2c


# instance fields
.field public isCreated:Z

.field public isReceived:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23464
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallState;-><init>()V

    .line 23465
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z

    .line 23454
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallState;-><init>()V

    .line 23455
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$CallStatePending;->isCreated:Z

    .line 23456
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$CallStatePending;->isReceived:Z

    .line 23457
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23461
    const v0, 0x3ff56c2c

    return v0
.end method
