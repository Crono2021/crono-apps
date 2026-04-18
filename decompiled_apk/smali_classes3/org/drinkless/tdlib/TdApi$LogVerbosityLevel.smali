.class public Lorg/drinkless/tdlib/TdApi$LogVerbosityLevel;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LogVerbosityLevel"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x676443ea


# instance fields
.field public verbosityLevel:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16188
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16189
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16179
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16180
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$LogVerbosityLevel;->verbosityLevel:I

    .line 16181
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16185
    const v0, 0x676443ea

    return v0
.end method
