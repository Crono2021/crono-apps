.class public Lorg/drinkless/tdlib/TdApi$ConnectionStateWaitingForNetwork;
.super Lorg/drinkless/tdlib/TdApi$ConnectionState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ConnectionStateWaitingForNetwork"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x650dd758


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1634
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ConnectionState;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 1639
    const v0, 0x650dd758

    return v0
.end method
