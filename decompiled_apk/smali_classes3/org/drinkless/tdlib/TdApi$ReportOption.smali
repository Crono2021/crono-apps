.class public Lorg/drinkless/tdlib/TdApi$ReportOption;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportOption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x41f22c20


# instance fields
.field public id:[B

.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30208
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 30209
    return-void
.end method

.method public constructor <init>([BLjava/lang/String;)V
    .locals 0
    .param p1, "bArr"    # [B
    .param p2, "str"    # Ljava/lang/String;

    .line 30198
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 30199
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReportOption;->id:[B

    .line 30200
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ReportOption;->text:Ljava/lang/String;

    .line 30201
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30205
    const v0, 0x41f22c20

    return v0
.end method
