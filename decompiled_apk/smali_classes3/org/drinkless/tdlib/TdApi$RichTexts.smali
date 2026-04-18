.class public Lorg/drinkless/tdlib/TdApi$RichTexts;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTexts"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6232361d


# instance fields
.field public texts:[Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19122
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19123
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richTextArr"    # [Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19113
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19114
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTexts;->texts:[Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19115
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19119
    const v0, 0x6232361d

    return v0
.end method
