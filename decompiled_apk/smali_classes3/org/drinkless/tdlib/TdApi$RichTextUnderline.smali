.class public Lorg/drinkless/tdlib/TdApi$RichTextUnderline;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextUnderline"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1ff30274


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19104
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19105
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19095
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19096
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextUnderline;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19097
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19101
    const v0, -0x1ff30274

    return v0
.end method
