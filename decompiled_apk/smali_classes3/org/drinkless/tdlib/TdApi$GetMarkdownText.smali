.class public Lorg/drinkless/tdlib/TdApi$GetMarkdownText;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMarkdownText"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FormattedText;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x9ce7228


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13074
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13075
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 13065
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13066
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetMarkdownText;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 13067
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13071
    const v0, 0x9ce7228    # 4.9700048E-33f

    return v0
.end method
