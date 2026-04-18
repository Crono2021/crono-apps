.class public Lorg/drinkless/tdlib/TdApi$AnswerCustomQuery;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AnswerCustomQuery"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4d1ad2c1


# instance fields
.field public customQueryId:J

.field public data:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22844
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22845
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 22834
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22835
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AnswerCustomQuery;->customQueryId:J

    .line 22836
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AnswerCustomQuery;->data:Ljava/lang/String;

    .line 22837
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22841
    const v0, -0x4d1ad2c1

    return v0
.end method
