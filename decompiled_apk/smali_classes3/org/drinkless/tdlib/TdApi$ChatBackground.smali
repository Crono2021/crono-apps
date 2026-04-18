.class public Lorg/drinkless/tdlib/TdApi$ChatBackground;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBackground"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x62891968


# instance fields
.field public background:Lorg/drinkless/tdlib/TdApi$Background;

.field public darkThemeDimming:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23584
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23585
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Background;I)V
    .locals 0
    .param p1, "background"    # Lorg/drinkless/tdlib/TdApi$Background;
    .param p2, "i9"    # I

    .line 23574
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23575
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBackground;->background:Lorg/drinkless/tdlib/TdApi$Background;

    .line 23576
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ChatBackground;->darkThemeDimming:I

    .line 23577
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23581
    const v0, 0x62891968

    return v0
.end method
