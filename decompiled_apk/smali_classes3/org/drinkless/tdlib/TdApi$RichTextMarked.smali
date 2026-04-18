.class public Lorg/drinkless/tdlib/TdApi$RichTextMarked;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextMarked"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4bd12c7e


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19014
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19015
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19005
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19006
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextMarked;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19007
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19011
    const v0, -0x4bd12c7e

    return v0
.end method
