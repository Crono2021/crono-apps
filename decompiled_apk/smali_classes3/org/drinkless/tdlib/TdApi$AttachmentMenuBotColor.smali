.class public Lorg/drinkless/tdlib/TdApi$AttachmentMenuBotColor;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AttachmentMenuBotColor"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x64235ebc


# instance fields
.field public darkColor:I

.field public lightColor:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22924
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22925
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 22914
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22915
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBotColor;->lightColor:I

    .line 22916
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBotColor;->darkColor:I

    .line 22917
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22921
    const v0, 0x64235ebc

    return v0
.end method
