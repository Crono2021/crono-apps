.class public Lorg/drinkless/tdlib/TdApi$InputTextQuote;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputTextQuote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x48b592e4


# instance fields
.field public position:I

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27584
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27585
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;I)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "i9"    # I

    .line 27574
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27575
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputTextQuote;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 27576
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$InputTextQuote;->position:I

    .line 27577
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27581
    const v0, -0x48b592e4

    return v0
.end method
