.class public Lorg/drinkless/tdlib/TdApi$InputChecklistTask;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputChecklistTask"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x615ca7d1


# instance fields
.field public id:I

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27244
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27245
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 27234
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27235
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$InputChecklistTask;->id:I

    .line 27236
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputChecklistTask;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 27237
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27241
    const v0, 0x615ca7d1

    return v0
.end method
