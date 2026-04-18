.class public Lorg/drinkless/tdlib/TdApi$PageBlockCaption;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockCaption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x46565b8a


# instance fields
.field public credit:Lorg/drinkless/tdlib/TdApi$RichText;

.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29024
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29025
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;
    .param p2, "richText2"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 29014
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29015
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockCaption;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 29016
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockCaption;->credit:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 29017
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29021
    const v0, -0x46565b8a

    return v0
.end method
