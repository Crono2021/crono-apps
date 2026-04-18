.class public Lorg/drinkless/tdlib/TdApi$ToggleSupergroupJoinByRequest;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSupergroupJoinByRequest"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7ddf9fde


# instance fields
.field public joinByRequest:Z

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33488
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33489
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33478
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33479
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupJoinByRequest;->supergroupId:J

    .line 33480
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupJoinByRequest;->joinByRequest:Z

    .line 33481
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33485
    const v0, 0x7ddf9fde

    return v0
.end method
