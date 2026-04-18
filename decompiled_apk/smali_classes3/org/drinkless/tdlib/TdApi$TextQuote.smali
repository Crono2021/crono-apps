.class public Lorg/drinkless/tdlib/TdApi$TextQuote;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TextQuote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x798a474e


# instance fields
.field public isManual:Z

.field public position:I

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41010
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41011
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;IZ)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "i9"    # I
    .param p3, "z8"    # Z

    .line 40999
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41000
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TextQuote;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 41001
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$TextQuote;->position:I

    .line 41002
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$TextQuote;->isManual:Z

    .line 41003
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41007
    const v0, -0x798a474e

    return v0
.end method
