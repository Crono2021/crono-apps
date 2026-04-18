.class public Lorg/drinkless/tdlib/TdApi$TranslateText;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TranslateText"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FormattedText;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x252264f2


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public toLanguageCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33648
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33649
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;Ljava/lang/String;)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "str"    # Ljava/lang/String;

    .line 33638
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33639
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TranslateText;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 33640
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$TranslateText;->toLanguageCode:Ljava/lang/String;

    .line 33641
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33645
    const v0, 0x252264f2

    return v0
.end method
