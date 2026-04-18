.class public Lorg/drinkless/tdlib/TdApi$SendGroupCallMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendGroupCallMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2061245c


# instance fields
.field public groupCallId:I

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30868
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30869
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 30858
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30859
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SendGroupCallMessage;->groupCallId:I

    .line 30860
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SendGroupCallMessage;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 30861
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30865
    const v0, -0x2061245c

    return v0
.end method
