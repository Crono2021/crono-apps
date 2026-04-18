.class public Lorg/drinkless/tdlib/TdApi$SetAlarm;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetAlarm"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x341081eb


# instance fields
.field public seconds:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19392
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19393
    return-void
.end method

.method public constructor <init>(D)V
    .locals 0
    .param p1, "d9"    # D

    .line 19383
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19384
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetAlarm;->seconds:D

    .line 19385
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19389
    const v0, -0x341081eb    # -3.1390762E7f

    return v0
.end method
