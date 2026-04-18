.class public Lorg/drinkless/tdlib/TdApi$AddLogMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddLogMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5f36cfec


# instance fields
.field public text:Ljava/lang/String;

.field public verbosityLevel:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22764
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22765
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;

    .line 22754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22755
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AddLogMessage;->verbosityLevel:I

    .line 22756
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AddLogMessage;->text:Ljava/lang/String;

    .line 22757
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22761
    const v0, 0x5f36cfec

    return v0
.end method
