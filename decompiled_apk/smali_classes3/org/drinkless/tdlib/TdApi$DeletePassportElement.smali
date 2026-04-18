.class public Lorg/drinkless/tdlib/TdApi$DeletePassportElement;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeletePassportElement"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x667e558c


# instance fields
.field public type:Lorg/drinkless/tdlib/TdApi$PassportElementType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11328
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11329
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PassportElementType;)V
    .locals 0
    .param p1, "passportElementType"    # Lorg/drinkless/tdlib/TdApi$PassportElementType;

    .line 11319
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11320
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeletePassportElement;->type:Lorg/drinkless/tdlib/TdApi$PassportElementType;

    .line 11321
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11325
    const v0, -0x667e558c

    return v0
.end method
