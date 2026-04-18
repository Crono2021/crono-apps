.class public Lorg/drinkless/tdlib/TdApi$PageBlockSubheader;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockSubheader"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b567326


# instance fields
.field public subheader:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17268
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17269
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17259
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17260
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockSubheader;->subheader:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17261
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17265
    const v0, 0x4b567326    # 1.4054182E7f

    return v0
.end method
