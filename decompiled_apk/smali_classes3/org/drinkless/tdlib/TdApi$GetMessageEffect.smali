.class public Lorg/drinkless/tdlib/TdApi$GetMessageEffect;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessageEffect"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$MessageEffect;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x61aec2ec


# instance fields
.field public effectId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13110
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13111
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13101
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13102
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessageEffect;->effectId:J

    .line 13103
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13107
    const v0, -0x61aec2ec

    return v0
.end method
