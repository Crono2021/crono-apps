.class public Lorg/drinkless/tdlib/TdApi$ReportChatResultTextRequired;
.super Lorg/drinkless/tdlib/TdApi$ReportChatResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportChatResultTextRequired"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7433cf3f


# instance fields
.field public isOptional:Z

.field public optionId:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30188
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReportChatResult;-><init>()V

    .line 30189
    return-void
.end method

.method public constructor <init>([BZ)V
    .locals 0
    .param p1, "bArr"    # [B
    .param p2, "z8"    # Z

    .line 30178
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReportChatResult;-><init>()V

    .line 30179
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReportChatResultTextRequired;->optionId:[B

    .line 30180
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ReportChatResultTextRequired;->isOptional:Z

    .line 30181
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30185
    const v0, -0x7433cf3f

    return v0
.end method
