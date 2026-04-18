.class public Lorg/drinkless/tdlib/TdApi$RichTextBold;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextBold"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x63970f6c


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18960
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 18961
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 18951
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 18952
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextBold;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 18953
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18957
    const v0, 0x63970f6c

    return v0
.end method
